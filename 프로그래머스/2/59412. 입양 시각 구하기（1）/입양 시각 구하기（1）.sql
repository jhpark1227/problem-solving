SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9 AND HOUR(DATETIME) < 20
GROUP BY DATE_FORMAT(DATETIME, '%h')
ORDER BY HOUR