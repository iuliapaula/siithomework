--1. Să se selecteze deptno, enume, job și sal pentru angajatii care au sef-ul cu id-ul 7902.
SELECT DEPTNO, ENAME, JOB, SAL FROM EMP WHERE MGR = 7902;
--2. Să se selecteze numele, funcția și salariu pentru angajații care au aceași funcție.
SELECT ENAME, JOB, SAL FROM EMP WHERE JOB IN (SELECT JOB from EMP GROUP BY JOB HAVING COUNT(ENAME) > 1);
--3. Să se selecteze numele, funcția și salariul anual pentru toți angajații din același departament.
SELECT ENAME, JOB, SAL FROM EMP WHERE deptno IN (SELECT DEPTNO FROM emp GROUP BY DEPTNO HAVING COUNT(ENAME) > 1);
--4. Să se selecteze numele, funcția și venitul lunar pentru toți angajații care au venitul lunar mai mare de 2000.
-- Venitul lunar este o funcție care are formula salariu + ifnull(comision, 0)
SELECT ENAME, JOB, (SAL + COALESCE(COMM, 0)) "revenue" FROM EMP WHERE (SAL + COALESCE(COMM, 0)) > 2000;
--5.Să se selecteze id-ul angajatului, numele, funcția și data angajării pentru toți angajații care au aceași funcție și au venit în firmă după o anumită dată.
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP
WHERE JOB IN (SELECT JOB from EMP GROUP BY JOB HAVING COUNT(ENAME) > 1) AND HIREDATE > '1981-10-10';
--6. Să se adauge 10 noi angajati.
INSERT INTO EMP VALUES
(1000, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20),
 (1001, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30),
 (1002, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30),
 (1003, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20),
 (1004, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
 (1005, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30),
 (1006, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10),
 (1007, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000, NULL, 20),
 (1008, 'DAN', 'ANALYST', 7566, '1981-11-17', 5000, NULL, 10),
 (1009, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);
--7. Să se calculeze o primă de 15% pentur toți angajații din departamentul 20.
UPDATE EMP SET COMM = 0.15 * SAL WHERE deptno = 20;
--8. Să se selecteze id-ul și numele departamentului din tabela departamente.
SELECT deptno, DNAME FROM DEPT;
--9. Să se selecteze id-ul, numele, funcția și data angajării pentru toți angajații din firmă.
-- Ordonați descrescător în funcție de id. Concatenați id-ul cu numele.
SELECT EMPNO, ENAME, concat(empno, ename) "IDNAME", JOB, HIREDATE FROM EMP ORDER BY EMPNO DESC;
--10. Să se selecteze id-ul, numele, fucția și venitul lunar pentru toți angajatii din firmă.
SELECT EMPNO, ENAME, JOB, SAL FROM EMP;
-- Să se adauge la select o coloană goală care să se numească semnătura. Concatenați id-ul cu numele. Ordonați după departament.
SELECT CONCAT(EMPNO, ENAME), JOB, SAL, null "Semnatura" FROM EMP ORDER BY deptno;
--11. Să se selecteze numele și funcția angajaților.
SELECT ENAME, JOB FROM EMP;
--12. Să se facă o listă cu numele departamentului și codul acestuia. Ordonați după numele departamentului.
SELECT DNAME, DEPTNO FROM DEPT ORDER BY DNAME;
--13. Să se selecteze toți angajații care au funcția manager. Ordonați după id-ul departamentului
SELECT * FROM EMP WHERE JOB = 'MANAGER' ORDER BY DEPTNO;
--14. Selectați toate persoanele care s-au angajat intr-o anumită perioadă aleasa de voi.
SELECT * FROM EMP WHERE HIREDATE BETWEEN '1981-09-28' AND '1981-12-03';
--15. Să se listeze id-ul, numele, funcția, venitul lunar pentru angajații care au următoarele id-uri: 7499,7902, 7876
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE EMPNO IN (7499, 7902, 7876);
--16. Să se selecteze toate persoanele care au fost angajate în anul 1980
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1980;
--17. Să se selecteze toate persoanele al căror nume începe cu litera F și numele funcției are 7 caractere.
SELECT * FROM EMP WHERE ENAME LIKE 'F______';
--18. Să se listeze angajații din departamentul 20 care nu au primit comision.
SELECT * FROM EMP WHERE deptno = 20 AND (comm = 0 OR comm IS NULL);
--19. Să se listeze angajații care au primit comision și au funcția SALESMAN
SELECT * FROM EMP WHERE COMM > 0 AND JOB = 'SALESMAN';
--20. Să se selecteze toți angajații care au funcția MANAGER și salariul peste 1500
-- și toți angajații care au funcția ANALYST.
SELECT * FROM EMP WHERE (JOB = 'MANAGER' AND SAL > 1500) OR JOB = 'ANALYST';
--21. Selectați toți angajații care s-au angajat înainte de anul 1982 și nu au primit comision.
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM hiredate) < 1982 AND (comm = 0 OR COMM IS NULL);
--22. Selectați toți angajații care au salariul peste 3000 și nu au șefi, ordonați după departament.
SELECT * FROM EMP WHERE SAL > 3000 AND MGR IS NULL ORDER BY deptno;
--23. Selectați numele, funcția și venitul anual al angajaților care nu au funcția MANAGER pentru un departament ales de voi.
SELECT ename, job, sal FROM emp WHERE JOB = 'MANAGER' AND deptno = 30;
--24. Selectați departamentul, numele, data angajării și salariul tuturor persoanelor angajate în anul 1981
-- din două departamente alese de voi.
SELECT deptno, ename, hiredate, sal FROM emp WHERE EXTRACT(YEAR FROM hiredate) = 1981 AND (deptno = 10 OR deptno = 30);



