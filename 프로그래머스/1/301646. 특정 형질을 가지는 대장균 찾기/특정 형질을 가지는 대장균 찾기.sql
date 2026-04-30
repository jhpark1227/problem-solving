SELECT COUNT(*) 'COUNT'
FROM ecoli_data
WHERE 
genotype & 2 = 0
AND (genotype & 5 = 1
OR genotype & 5 = 4
OR genotype & 5 = 5)