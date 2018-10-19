package com.leihou.so.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户的手机号码
     */
    private String telephone;

    private Date created;

    private Date updated;

    /**
     * 渠道 pc  android ios  weixin
     */
    private String channel;

    /**
     * 企业Id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 状态 0 不通过  1 通过
     */
    private Integer status;

    /**
     * 名称
     */
    private String name;

    /**
     * 1 管理员  2员工
     */
    private Integer role;

    /**
     * 头像
     */
    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 1男性 2女性 
     */
    private Integer sex;

    /**
     * 岗位
     */
    private String position;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备注名
     */
    @Column(name = "remark_name")
    private String remarkName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户的手机号码
     *
     * @return telephone - 用户的手机号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置用户的手机号码
     *
     * @param telephone 用户的手机号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取渠道 pc  android ios  weixin
     *
     * @return channel - 渠道 pc  android ios  weixin
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置渠道 pc  android ios  weixin
     *
     * @param channel 渠道 pc  android ios  weixin
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 获取企业Id
     *
     * @return company_id - 企业Id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置企业Id
     *
     * @param companyId 企业Id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取状态 0 不通过  1 通过
     *
     * @return status - 状态 0 不通过  1 通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 不通过  1 通过
     *
     * @param status 状态 0 不通过  1 通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1 管理员  2员工
     *
     * @return role - 1 管理员  2员工
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置1 管理员  2员工
     *
     * @param role 1 管理员  2员工
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取头像
     *
     * @return head_img_url - 头像
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 设置头像
     *
     * @param headImgUrl 头像
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    /**
     * 获取1男性 2女性 
     *
     * @return sex - 1男性 2女性 
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1男性 2女性 
     *
     * @param sex 1男性 2女性 
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取岗位
     *
     * @return position - 岗位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置岗位
     *
     * @param position 岗位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取备注名
     *
     * @return remark_name - 备注名
     */
    public String getRemarkName() {
        return remarkName;
    }

    /**
     * 设置备注名
     *
     * @param remarkName 备注名
     */
    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }
}