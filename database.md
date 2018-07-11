### [175. Combine Two Tables](https://leetcode.com/problems/combine-two-tables/description/)

```sql
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;
```

+ left join


### [176. Second Highest Salary](https://leetcode.com/problems/second-highest-salary/description/)


> 解法参考 <https://leetcode.com/problems/second-highest-salary/solution/>

###### distinct limit (solution说要用IFNULL,但是没用也通过了)
```sql
select (select distinct Salary from Employee order by Salary desc limit 1,1) as SecondHighestSalary;
```

###### top
```sql
-- select (select distinct Salary from Employee order by Salary desc limit 1,1) as SecondHighestSalary;
```


+ limit 1,1 
> limit startrow, rownum. 
>> [startRow, startRow+rownum)  [The offset of the initial row is 0 (not 1)](https://dev.mysql.com/doc/refman/8.0/en/select.html) limit 2, 4即表示第3,4,5,6行。

> [sql语句执行顺序](https://www.jianshu.com/p/bb19b6b0fdc3)