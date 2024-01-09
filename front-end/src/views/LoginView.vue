<template>
  <div class="login">
    <div class="el-container ">
      <div class="el-aside" >
        <el-image class="el-image" :src="require('../assets/login/floatingcity.jpg')" :fit="'cover'"/>
      </div>
      <div id="form">
        <el-col>
          <el-row justify="center" align="top">
            <el-text class="text" style="">账户验证</el-text>
          </el-row>
          <el-row justify="center" id="user">
            <el-input v-model="username" placeholder="用户名" clearable class="in"><template #prefix>
              <el-icon class="el-input__icon"><User /></el-icon>
            </template></el-input>
            <div class="line"></div>
          </el-row>
          <el-row justify="center" id="user">
            <el-input v-model="password" placeholder="密码" type="password" show-password clearable class="in">
              <template #prefix>
              <el-icon class="el-input__icon"><Lock /></el-icon>
            </template>
            </el-input>
            <div class="line"></div>
          </el-row>
          <el-row justify="center" id="login">
            <div class="ButtonBg">
              <el-button class="loginButton" type="primary" @click="Login">
              点击登录
            </el-button>
            </div>
          </el-row>
        </el-col>
      </div>
    </div>
  </div>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login{
  position:absolute;
  height: 100%;
  width: 100%;
  background-color: rgb(231,228,241);
  padding: 0
}
.el-container{
  position:absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
  height: 50%;
  width: 50%;
  background-color:transparent;
  overflow: hidden;
  box-shadow: 0 0 35px rgb(128,128,128);
}
.el-aside{
  width: 35%;
  background-color:transparent;
}
.el-image{
  position:absolute;
  left: 20%;
  top: 50%;
  transform: translate(-50%,-50%);
  height: 100%;
  width:100%;
  z-index: 0;
}
#form{
  background-color:white;
  z-index:1;
  width: 65%;
  height: 100%;
}

.text {
  font-size: 30px;
  padding-top: 5%;
  color: transparent;
  background-clip: text;
  -webkit-background-clip: text;
  background-image: linear-gradient(103.58deg, rgba(130, 149, 255, 1) 0%, rgba(201, 124, 252, 1) 100%);
  background-size: 200% auto;
  animation: an 2s linear infinite;
}

#user{
  margin: 10% 15% 10% 15%;
}

>>>#user .el-input{
  border: none;
  margin: 0;
  --el-input-border:0;
  --el-input-hover-border:0;
  --el-input-focus-border:0;
  --el-input-border-color:0;
  --el-input-hover-border-color:0;
  --el-input-focus-border-color:0;
  --el-input-text-color:rgba(128, 128, 128, 1);
}

.in{
  font-size: 18px;
  font-weight: 300;
  color: rgba(128, 128, 128, 1);
}


#login{
  height: 40px;
  margin: 5% 15% 5% 15%;
}

.loginButton{
  z-index: 2;
  height: 100%;
  width: 90%;
  text-align: center;
  --el-button-bg-color: rgba(0, 0, 0, 0);
  --el-button-border-color: rgba(0, 0, 0, 0);
  --el-button-outline-color: rgba(0, 0, 0, 0);
  --el-button-active-color: rgba(0, 0, 0, 0);
  --el-button-hover-text-color: rgba(200, 200, 200, 1);
  --el-button-hover-link-text-color: rgba(0, 0, 0, 0);
  --el-button-hover-bg-color: rgba(0, 0, 0, 0);
  --el-button-hover-border-color: rgba(0, 0, 0, 0);
  --el-button-active-bg-color: rgba(0, 0, 0, 0);
  --el-button-active-border-color: rgba(0, 0, 0, 0);
}

.ButtonBg{
  z-index: 1;
  height: 100%;
  width: 100%;
  border-radius: var(--el-border-radius-base);
  background-image: repeating-linear-gradient(45deg, rgba(130, 149, 255, 1) 0%, rgba(201, 124, 252, 1) 100%);
  background-size: 200% auto;
}
.line{
  height: 2px;
  width: 100%;
  background-color: black;
  text-align: center;
  background-image: linear-gradient(45deg, rgba(130, 149, 255, 1) 0%, rgba(201, 124, 252, 1) 100%);
  background-size: 200% auto;
  animation: an 2s linear infinite;
}

@keyframes an {
  to {
    background-position: 200%;
  }
}

</style>

<script lang="ts" setup>
import { ref } from "vue";
import UserRegister from "@/api/UserRegister";
import UserLogin from "@/api/UserLogin";
import {ElNotification} from "element-plus";
import { Lock,User} from '@element-plus/icons-vue'

let username = ref("");
let password = ref("");

let message = ref("");
function Login(){
  if(username.value.length>0 && password.value.length>0){
    if(username.value.length>=3&&username.value.length<=16){
      if(password.value.length>=6&&password.value.length<=18){
        UserLogin(username.value,password.value,message);
      }else ElNotification({title:"提示",message:"密码必须在6到18位之间",type:"warning",customClass:"RegisterWarn",duration:800});
    }else ElNotification({title:"提示",message:"用户名必须在3到16位之间",type:"warning",customClass:"RegisterWarn",duration:800});
  }else {
    ElNotification({title:"提示",message:"用户名和密码不能为空",type:"warning",customClass:"LoginWarn",duration:800});
  }
}

function Register(){
  if(username.value.length>0 && password.value.length>0){
    if(username.value.length>=3&&username.value.length<=16){
      if(password.value.length>=6&&password.value.length<=18){
        UserRegister(username.value,password.value,message);
      }else ElNotification({title:"提示",message:"密码必须在6到18位之间",type:"warning",customClass:"RegisterWarn",duration:2000});
    }else ElNotification({title:"提示",message:"用户名必须在3到16位之间",type:"warning",customClass:"RegisterWarn",duration:2000});
  }else {
    ElNotification({title:"提示",message:"用户名和密码不能为空",type:"warning",customClass:"RegisterWarn",duration:2000});
  }
}
</script>
