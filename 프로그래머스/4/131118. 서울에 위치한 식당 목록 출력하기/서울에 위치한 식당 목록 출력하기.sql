SELECT A.rest_id, rest_name, food_type, favorites, address, B.avg_score AS score
FROM rest_info AS A
JOIN (
    SELECT rest_id, ROUND(AVG(review_score), 2) AS avg_score
    FROM rest_review
    GROUP BY rest_id
) AS B ON B.rest_id = A.rest_id
WHERE address LIKE '서울%'
ORDER BY score DESC, favorites DESC