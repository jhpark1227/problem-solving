WITH csharp_developers AS
(SELECT d.*
FROM developers AS d
JOIN (SELECT code FROM skillcodes WHERE name = 'C#') AS sc
ON sc.code & d.skill_code),
python_developers AS
(SELECT d.*
FROM developers AS d
JOIN (SELECT code FROM skillcodes WHERE name = 'Python') AS sc
ON sc.code & d.skill_code),
front_developers AS
(SELECT d.*
FROM developers AS d
JOIN (SELECT CODE FROM SKILLCODES WHERE CATEGORY = 'Front End') AS SC
ON SC.CODE & D.SKILL_CODE)

SELECT 
    (CASE
        WHEN (
            id IN (SELECT id FROM front_developers)
              AND id IN (SELECT id FROM python_developers)
        )
        THEN 'A'
        WHEN (id IN (SELECT id FROM csharp_developers))
        THEN 'B'
        WHEN (id IN (SELECT id FROM front_developers))
        THEN 'C'
        ELSE 'E'
    END) 'GRADE',
    ID,
    EMAIL
FROM developers
WHERE id IN (SELECT id FROM front_developers)
              OR id IN (SELECT id FROM csharp_developers)
ORDER BY 1, 2