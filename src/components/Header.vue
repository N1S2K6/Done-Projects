<script>

export default {
  name: "Header",
  data(){
    return {
      user : JSON.parse(sessionStorage.getItem('CurUser'))
    }
  },
  props:{
    icon:String
  },
  methods:{
    toUser(){
      console.log('to_user')
      this.$router.push({path:'Home'});
      console.log("router",this.$router)
    },
    logout(){
      console.log('log_out')

      this.$confirm('您确定要退出登录吗？','提示',{
        confirmButtonText: '确定', //确认按钮的文字
        type: 'warning',
        center: true, //居中
        showCancelButton: true, //是否显示取消按钮
        showClose: false, //是否显示右上角的X
        closeOnClickModal: true, //是否可以点击空白处关闭弹窗
      })
        .then(() => {
          this.$message({
            type:'success',
            message:'退出登录成功'
          })

          this.$router.push({path:'/'});

          sessionStorage.clear()
        }) //点击确定时触发
        .catch(() => {
          this.$message({
            type:'info',
            message:'已取消退出登录'
          })
        }) //点击取消时触发

    },
    collapse(){
      this.$emit('doCollapse')
    }
  },
  created() {
    this.$router.push({path:'Home'});

  }
}
</script>

<template>
  <div style="display: flex;line-height: 60px">
    <div style="margin-top: 8px;">
      <i :class="icon" style="font-size: 20px;cursor: pointer;" @click="collapse"></i>
    </div>
    <div style="flex: 1;text-align: center;font-size: 34px;">
      <span>欢迎来到仓库管理系统</span>
    </div>
    <el-dropdown>
      <span>{{ user.name }}</span><i class="el-icon-arrow-down" style="margin-left:5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
        <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<style scoped>

</style>
