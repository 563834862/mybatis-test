# mybatis-test
mybatis功能测试
### mybatis 批量新增返回主键id
mysql 配置时，url
```
url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
```
spring boot 下写mybatis 单元测试
```
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class UserDaoTests {
    @Resource
    private UserDao userDao;
```
批量新增回返主键Id
```
 <insert id="batchInsertUser" useGeneratedKeys="true" keyProperty="id">
        insert into user(name)values
        <foreach collection="list" item="item" separator=",">
            (#{item.name})
        </foreach>
    </insert>
```
bug1: 整合 mybatis, 需要添加一些代码，未添加会启动报错
```
@SpringBootApplication
@MapperScan
public class MybatisTestApplication {
```
bug2: statment 找不到,  pom.xml 未对resources目录扫描。或者，mapper-locations 路径不符合要求
```
mybatis:
  mapper-locations: classpath:mapping/*Mapping.xml
```
注意： 旧版本批量新增返回主键Id会报错,以下是修复的issue
https://github.com/mybatis/mybatis-3/pull/547
错误日志：
```
org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.executor.ExecutorException: 
Error getting generated key or setting result to parameter object. 
Cause: org.apache.ibatis.binding.BindingException: 
Parameter 'articleHomeUserId' not found. Available parameters are [list, param1]
```
