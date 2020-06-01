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
