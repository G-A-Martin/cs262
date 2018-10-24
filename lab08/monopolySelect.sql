

--SELECT * 
--FROM Game
--ORDER BY time DESC;


--SELECT *
--FROM Game
--WHERE time > CURRENT_DATE - 7;

--SELECT * 
--FROM Player
--WHERE NAME is not NULL;

--SELECT * 
--FROM PlayerGame
--WHERE score > 2000;

--SELECT * 
--FROM Player
--WHERE emailAddress like '%gmail.edu';



-- MULTIPLE TABLE QUERIES 


--SELECT pg.gameid, p.name, pg.score
--from playerGame pg INNER JOIN Player p 
--    ON pg.playerID = p.ID
--WHERE pg.playerID = 2
--ORDER BY pg.score DESC;



--SELECT * FROM
--(Select sub.name, sub.score, sub.time from
--    (SELECT *
--    FROM GAME g INNER JOIN playerGame pg
--        ON g.id = pg.gameID INNER JOIN player p
--        ON p.ID = pg.playerID
--    WHERE time = '2006-06-28 13:20:00') sub
--ORDER BY sub.score DESC) sub2
--LIMIT 1;

-- C
-- I believe it does a cartesian product with the values greater than itself. One would do a cartesian product with the greater ones, and it would continue

-- D 

-- There are many senarios to use a self join, but its used when the data
-- you are using needs to reference the data in its own table. An example is a child-parent relationship within a table