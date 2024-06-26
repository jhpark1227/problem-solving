SELECT DISTINCT A.CAR_ID, A.CAR_TYPE, TRUNCATE(A.DAILY_FEE*30*(100-C.DISCOUNT_RATE)/100,0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS A
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS C ON C.CAR_TYPE = A.CAR_TYPE
WHERE A.CAR_ID NOT IN 
    (
     SELECT DISTINCT CAR_ID 
     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
     WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
    )
    AND C.DURATION_TYPE = '30일 이상'
    AND A.DAILY_FEE*30*(100-C.DISCOUNT_RATE)/100 BETWEEN 500000 AND 1999999
    AND A.CAR_TYPE IN ('세단','SUV')
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC