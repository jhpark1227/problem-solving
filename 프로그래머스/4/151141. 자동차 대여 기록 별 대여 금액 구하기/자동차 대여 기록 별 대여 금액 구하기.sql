

SELECT A.HISTORY_ID,
       ROUND((DATEDIFF(A.END_DATE, A.START_DATE) + 1) * B.DAILY_FEE - 
       0.01 * IFNULL(C.DISCOUNT_RATE,0) * (DATEDIFF(A.END_DATE, A.START_DATE) + 1)* B.DAILY_FEE)
       AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
JOIN CAR_RENTAL_COMPANY_CAR AS B USING (CAR_ID)
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C 
ON (CASE
   WHEN DATEDIFF(A.END_DATE, A.START_DATE) + 1 >= 90 THEN '90일 이상'
   WHEN DATEDIFF(A.END_DATE, A.START_DATE) + 1 >= 30 THEN '30일 이상'
   WHEN DATEDIFF(A.END_DATE, A.START_DATE) + 1 >= 7 THEN '7일 이상'
   ELSE NULL END) = C.DURATION_TYPE
   AND B.CAR_TYPE = C.CAR_TYPE
WHERE B.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC