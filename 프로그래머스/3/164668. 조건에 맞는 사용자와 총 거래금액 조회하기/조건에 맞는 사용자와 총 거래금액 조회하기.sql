-- 코드를 입력하세요
SELECT U.USER_ID, U.NICKNAME, SUM(G.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER AS U
JOIN 
    (SELECT * FROM USED_GOODS_BOARD WHERE STATUS = 'DONE') AS G 
ON U.USER_ID = G.WRITER_ID
GROUP BY G.WRITER_ID HAVING SUM(G.PRICE) >= 700000
ORDER BY TOTAL_SALES