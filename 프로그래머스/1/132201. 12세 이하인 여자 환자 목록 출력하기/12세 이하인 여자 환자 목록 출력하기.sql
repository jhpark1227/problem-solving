SELECT pt_name, pt_no, gend_cd, age, IFNULL(tlno, 'NONE') AS TLNO
FROM patient
WHERE age <= 12 AND GEND_CD = 'W'
ORDER BY age DESC, pt_name ASC