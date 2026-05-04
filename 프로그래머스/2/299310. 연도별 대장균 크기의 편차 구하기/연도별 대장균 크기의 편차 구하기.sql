SELECT year, year_max - size_of_colony AS year_dev, id
FROM ecoli_data AS a
JOIN (
    SELECT 
        MAX(size_of_colony) AS year_max,
        YEAR(differentiation_date) AS year
    FROM ecoli_data
    GROUP BY YEAR(differentiation_date)
) AS b
ON YEAR(a.differentiation_date) = b.year
ORDER BY 1, 2