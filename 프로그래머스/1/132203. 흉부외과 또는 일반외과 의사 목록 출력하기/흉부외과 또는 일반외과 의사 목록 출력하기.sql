SELECT dr_name, dr_id, mcdp_cd, hire_ymd
FROM doctor
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY hire_ymd DESC, dr_name ASC