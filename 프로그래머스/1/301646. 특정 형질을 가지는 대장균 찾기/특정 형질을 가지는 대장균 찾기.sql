SELECT COUNT(*) 'COUNT'
FROM ecoli_data
WHERE 
genotype & 2 = 0
AND genotype & 5