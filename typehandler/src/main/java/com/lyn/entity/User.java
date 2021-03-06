package com.lyn.entity;

import com.lyn.constant.YesNoEnum;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;


/**
 * @author lyn
 * 光标移到类名上，按option+enter，选择自动生成版本号ID
 */
@Alias("User")
public class User implements Serializable {

    private static final long serialVersionUID = 3672666473327681247L;

    private Integer id;
    private String name;
    private String pwd;
    private Integer age;
    private String email;
    private YesNoEnum enable;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public YesNoEnum getEnable() {
        return enable;
    }

    public void setEnable(YesNoEnum enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                '}';
    }
}
