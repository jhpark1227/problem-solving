SELECT DISTINCT(A.CAR_ID)
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
JOIN CAR_RENTAL_COMPANY_CAR AS B USING (CAR_ID)
WHERE MONTH(A.START_DATE) = 10 AND B.CAR_TYPE = '세단'
ORDER BY A.CAR_ID DESC