SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM developers
JOIN (SELECT code
    FROM skillcodes
    WHERE category = 'Front End') AS sc
ON sc.code & developers.skill_code
ORDER BY id