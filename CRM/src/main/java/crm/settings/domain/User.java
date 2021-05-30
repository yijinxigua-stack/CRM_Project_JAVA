package crm.settings.domain;

public class User {
   /**
    * 登录
    * 验证账号密码
    * User user=select * from tbl_user where loginAct=? and loginPwd=?
    * user为null 账号密码错误 登录失败
    * user不为null 账号密码正确 继续验证
    * 从user中get
    * expireTime 验证失效时间
    * lockState 验证锁定状态
    * allowIps 验证浏览器ip地址是否有效
    */
   private String name;//用户名
   private String loginPwd;//密码
   private String loginAct;//账号
   private String lockState;//锁定状态 0：锁定 1：启用
   private String id;//编号 主键
   private String expireTime;//失效时间
   private String email;//邮箱
   private String editTime;//修改时间
   private String editBy;//修改人
   private String deptno;//部门编号
   private String createTime;//创建时间
   private String createBy;//创建人
   private String allowIps;//允许访问的ip地址

   public String getName() {
      return name;
   }

   public String getLoginPwd() {
      return loginPwd;
   }

   public String getLoginAct() {
      return loginAct;
   }

   public String getLockState() {
      return lockState;
   }

   public String getId() {
      return id;
   }

   public String getExpireTime() {
      return expireTime;
   }

   public String getEmail() {
      return email;
   }

   public String getEditTime() {
      return editTime;
   }

   public String getEditBy() {
      return editBy;
   }

   public String getDeptno() {
      return deptno;
   }

   public String getCreateTime() {
      return createTime;
   }

   public String getCreateBy() {
      return createBy;
   }

   public String getAllowIps() {
      return allowIps;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setLoginPwd(String loginPwd) {
      this.loginPwd = loginPwd;
   }

   public void setLoginAct(String loginAct) {
      this.loginAct = loginAct;
   }

   public void setLockState(String lockState) {
      this.lockState = lockState;
   }

   public void setId(String id) {
      this.id = id;
   }

   public void setExpireTime(String expireTime) {
      this.expireTime = expireTime;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setEditTime(String editTime) {
      this.editTime = editTime;
   }

   public void setEditBy(String editBy) {
      this.editBy = editBy;
   }

   public void setDeptno(String deptno) {
      this.deptno = deptno;
   }

   public void setCreateTime(String createTime) {
      this.createTime = createTime;
   }

   public void setCreateBy(String createBy) {
      this.createBy = createBy;
   }

   public void setAllowIps(String allowIps) {
      this.allowIps = allowIps;
   }
}
