SELECT COUNT(A.LENGTH) AS FISH_COUNT, MAX(A.LENGTH) AS MAX_LENGTH, A.FISH_TYPE
FROM (SELECT FISH_TYPE, IFNULL(LENGTH, 10) AS LENGTH FROM FISH_INFO) AS A
GROUP BY A.FISH_TYPE
HAVING AVG(A.LENGTH) >= 33
ORDER BY A.FISH_TYPE