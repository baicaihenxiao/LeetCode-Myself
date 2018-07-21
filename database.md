### [175. Combine Two Tables](https://leetcode.com/problems/combine-two-tables/description/)

```sql
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;
```

+ left join


### [176. Second Highest Salary](https://leetcode.com/problems/second-highest-salary/description/)


> 解法参考 <https://leetcode.com/problems/second-highest-salary/solution/>


#### Ans. 1
###### distinct limit (~~solution说要用IFNULL,但是没用也通过了~~)（这个有时候通过有时候不通过。。。测试用例没有用全集？）
```sql
-- 这样只有一条记录的时候不会输出值（即输出空表），而不是输出一行null
select (select distinct Salary from Employee order by Salary desc limit 1,1) as SecondHighestSalary;
```
> Return an alternative value IF the expression is NULL:
>> `SELECT IFNULL(NULL, "W3Schools.com");`
~~这意思不存在即为NULL，我先判断是否为NULL，再输出字符串NULL？~~ null应该是个变量

###### 使用IFNULL
```sql
select IFNULL((select distinct Salary from Employee order by Salary desc limit 1,1), null) as SecondHighestSalary;
```

###### mysql 不支持 top，使用 limit 1,1 
> limit startrow, rownum. 
>> [startRow, startRow+rownum)  [The offset of the initial row is 0 (not 1)](https://dev.mysql.com/doc/refman/8.0/en/select.html) limit 2, 4即表示第3,4,5,6行。



#### Ans. 2 待研究，这个也输出null，因为max函数的原因？
```sql
SELECT  MAX(salary) AS SecondHighestSalary
FROM    Employee
WHERE   salary NOT IN (
                        SELECT  MAX(salary)
                        FROM    Employee
                      )
```

Ref:
> [sql语句执行顺序](https://www.jianshu.com/p/bb19b6b0fdc3)

### [177. Nth Highest Salary](https://leetcode.com/problems/nth-highest-salary/description/)

不能limt N-1, 1 会报错

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N = N -1;
  RETURN (
      # Write your MySQL query statement below.
      select IFNULL((select distinct Salary from Employee order by Salary desc limit N, 1), NULL)  
  );
END
```

### [178. Rank Scores](https://leetcode.com/problems/rank-scores/description/)

###### count + distinct

```sql
select Score, (select  count(distinct Score) from Scores as t where s.Score <= t.Score ) as Rank from Scores as s order by Score desc
```