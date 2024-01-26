<template>
  <div class="user">
    <div class="left_menu_bg"></div>
    <div class="left_menu" id="left_menu">
        <div class="player_Avatar">
          <div class="player_Avatar_circle">
            <div class="player_Avatar_img"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="35.93017578125" height="36.000091552734375" viewBox="0 0 35.93017578125 36.000091552734375" fill="none"><path fill-rule="evenodd" style="fill:#383838" opacity="0.65" d="M6.11 11.2201C6.11 14.9601 8.05 18.2701 11.03 20.3101C8.83 21.1901 6.91 22.4101 5.26 23.9801C3.61 25.5401 2.32 27.3601 1.41 29.3801C0.52 31.3601 0.05 33.4701 0 35.6301C0 35.8301 0.17 36.0001 0.38 36.0001L3.25 36.0001C3.46 36.0001 3.63 35.8401 3.63 35.6501C3.73 32.1501 5.21 28.8901 7.83 26.4101C10.53 23.8401 14.13 22.4301 17.96 22.4301C21.79 22.4301 25.39 23.8401 28.1 26.4101C30.72 28.8901 32.2 32.1501 32.3 35.6501C32.3 35.8401 32.47 36.0001 32.68 36.0001L35.55 36.0001C35.76 36.0001 35.93 35.8301 35.93 35.6301C35.88 33.4701 35.41 31.3601 34.52 29.3801C33.61 27.3501 32.32 25.5301 30.67 23.9801C29.02 22.4101 27.1 21.1901 24.96 20.3301C27.88 18.2701 29.81 14.9601 29.81 11.2201C29.81 5.0201 24.51 0.0001 17.96 0.0001C11.42 0.0001 6.11 5.0201 6.11 11.2201ZM23.7763 16.7172C25.3263 15.2472 26.1863 13.2872 26.1863 11.2172C26.1863 9.1372 25.3263 7.1872 23.7763 5.7172C22.2163 4.2472 20.1563 3.4372 17.9663 3.4372C15.7763 3.4372 13.7063 4.2472 12.1563 5.7172C10.5963 7.1872 9.7463 9.1372 9.7463 11.2172C9.7463 13.2872 10.5963 15.2472 12.1563 16.7172C13.7063 18.1872 15.7763 18.9972 17.9663 18.9972C20.1563 18.9972 22.2163 18.1872 23.7763 16.7172Z"></path></svg></div>
          </div>
        </div>
        <div class="bar"></div>
        <div class="menu_list" >
<!--            <div class="menu" v-for="menu in menus"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" :width="menu.icon.width" :height="menu.icon.height" :viewBox="menu.icon.viewBox" fill="none"><path fill-rule="evenodd" style="fill:#000000" :opacity="menu.icon.opacity" :d="menu.icon.d"></path></svg><div class="title-div"><p class="title-text">{{menu.title}}</p></div></div>-->
            <div class="menu" v-for="menu in menus"><el-button class="menu_button" :id="menu.id" @click="setPage(menu.id)"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" :width="menu.icon.width" :height="menu.icon.height" :viewBox="menu.icon.viewBox" fill="none"><path fill-rule="evenodd" style="fill:#646438" :opacity="menu.icon.opacity" :d="menu.icon.d"></path></svg><div class="title-div" v-if="left_menu_isOpen">{{menu.title}}</div></el-button></div>
        </div>
    </div>
    <div class="main">
      <MainPageView></MainPageView>
      <router-view></router-view>
    </div>
  </div>
</template>



<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.user{
  display: flex;
  position:absolute;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
  background-color: rgb(231,228,241);
  padding: 0;
  flex-shrink: 0;
}
.left_menu_bg{
  position: relative;
  top: 0;
  bottom: 0;
  width: 70px;
  height: auto;
  z-index: 1;
}
.left_menu{
  overflow: hidden;
  border-radius: 30px;
  box-shadow: 5px 0 10px rgba(0, 0, 0, 0.25);
  background-color: rgb(250,250,252);
  position: absolute;
  top: 0;
  bottom: 0;
  left: -40px;
  width: 133px;
  height: auto;
  z-index: 1;
  transition: width 0.5s ease-in-out;
}

.left_menu:hover{
  width: 278.44px;
}

.menu_list{
  position: absolute;
  z-index: 3;
  left: 64px;
  top: 125px;
  width: 46.27px;
  height: 487.89px;
}

.player_Avatar{
  position: absolute;
  z-index: 7;
  left: 59px;
  top: 33px;
  width: 56px;
  height: 53px;
}

.player_Avatar_circle{
  position: absolute;
  z-index: 0;
  left: 0;
  top: 0;
  width: 55.52px;
  height: 52.56px;
  border-radius: 60px;
  background: rgba(235, 235, 240, 1);
}

.player_Avatar_img{
  position: absolute;
  z-index: 1;
  border: unset !important;
  box-shadow: unset;
  left: 10.1px;
  top: 9px;
  width: 35.929931640625px;
  height: 36.0001220703125px;
  background-size: cover;
}

.menu{
  position: relative;
  z-index: 2;
  margin-top: 3px;
  margin-bottom: 10px;
  border-radius: 12px;
}
.title-div{
  text-align: center;
  white-space: nowrap;
  user-select: none;
  position: relative;
  margin-left: 45px;
  z-index: 2;
  width: 100px;
  font-size: 24px;
  color: #646464;
}
.menu_list >>> button{
  background-color: rgba(0,0,0,0);
  padding: 8px;
  height: 45px;
  border: none;
  border-radius: 12px;
  color: #646464;
  transition: background-color 0.5s ease-in-out;
}

.bar{
  position: absolute;
  z-index: 3;
  border: unset !important;
  box-shadow: unset;
  left: 58px;
  top: 109.5px;
  right: 17px;
  height: 1px;
  background-color: rgb(166,166,166);
  background-size: cover;
  transition: width 1s ease-in-out;
}

.main{
  position: relative;
  height: 100%;
  width: 100%;
  z-index: 0;
}

</style>

<script lang="ts" setup>
import {onBeforeMount, onMounted, Ref, ref} from "vue";
import MainPageView from "@/views/MainPageView.vue";
import router from "@/router";

let menus: Ref<{id: number,route: string,icon: {width: string, height: string, viewBox: string,fill: string, opacity: string, d: string}, title: string}[]> = ref([]);
let Page=1;
let left_menu_isOpen=ref(false);


document.addEventListener("",function (){addLeftMenuListen()});
function addLeftMenuListen(){
  let left_menu=document.getElementById("left_menu");
  if(left_menu){
    left_menu.addEventListener("mouseleave",ev => {
      setTimeout(() => {left_menu_isOpen.value=false;},500)
    })
    left_menu.addEventListener("mousemove",ev => {
      left_menu_isOpen.value=true;
    })
  }
}

function setPage(page: number) {
  for(const item of menus.value){
    if(item.id == page){
      router.replace(item.route)
      setElementBgColor(item.id.toString(),"#E6EBFF");
    }else {
      setElementBgColor(item.id.toString(),"#FAFAFC")
    }
  }
}

function setElementBgColor(id:string,color:string){
  let element=document.getElementById(id);
  if(element!=null){
    element.style.backgroundColor = color;
  }
}

function registerMenuList() {
  //<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="26.990234375" height="32.84492492675781" viewBox="0 0 26.990234375 32.84492492675781" fill="none"><path id="Shape" fill-rule="evenodd" style="fill:#646438" opacity="1" d=""></path></svg>
  menus.value.push({
    id:1,
    route:"/main",
    icon: {
      width: "31.9228515625",
      height: "30.22003173828125",
      viewBox: "0 0 31.9228515625 30.22003173828125",
      fill: "#646464",
      opacity: "1",
      d: "M12.42 19.31C12.42 18.84 12.81 18.47 13.3 18.47L18.62 18.47C19.11 18.47 19.51 18.84 19.51 19.31L19.51 29.38C19.51 29.84 19.9 30.22 20.4 30.22L25.72 30.22C28.17 30.22 30.15 28.34 30.15 26.02L30.15 12.99L30.47 13.24C30.85 13.54 31.41 13.48 31.72 13.12C32.03 12.77 31.98 12.24 31.6 11.94L16.53 0.190033C16.2 -0.059967 15.73 -0.059967 15.4 0.190033L0.320032 11.94C-0.0499676 12.24 -0.109968 12.77 0.200032 13.12C0.510032 13.48 1.07003 13.54 1.45003 13.24L1.77003 12.99L1.77003 26.02C1.77003 28.34 3.76003 30.22 6.21003 30.22L11.53 30.22C12.02 30.22 12.42 29.84 12.42 29.38L12.42 19.31ZM28.3793 11.6207L15.9493 1.93073L3.52933 11.6207C3.53933 11.6607 3.53933 11.7507 3.53933 11.7507L3.53933 26.0207C3.53933 27.4107 4.72933 28.5407 6.19933 28.5407L10.6293 28.5407L10.6293 19.3107C10.6293 17.9207 11.8193 16.7907 13.2893 16.7907L18.6093 16.7907C20.0793 16.7907 21.2693 17.9207 21.2693 19.3107L21.2693 28.5407L25.7093 28.5407C27.1693 28.5407 28.3593 27.4107 28.3593 26.0207L28.3593 11.7507C28.3593 11.7507 28.3693 11.6607 28.3793 11.6207Z"
    }, title: "主页"
  });
  menus.value.push({
    id:2,
    route:"/user/notice",
    icon: {
      width: "33.2001953125",
      height: "31.420013427734375",
      viewBox: "0 0 33.2001953125 31.420013427734375",
      fill: "#646464",
      opacity: "1",
      d: "M33.2 15.71C33.2 7.04 25.76 0 16.6 0C7.43 0 0 7.04 0 15.71C0 24.39 7.43 31.42 16.6 31.42C25.76 31.42 33.2 24.39 33.2 15.71ZM31.6106 15.7164C31.6106 7.8664 24.8906 1.4964 16.6006 1.4964C8.3006 1.4964 1.5806 7.8664 1.5806 15.7164C1.5806 23.5664 8.3006 29.9264 16.6006 29.9264C24.8906 29.9264 31.6106 23.5664 31.6106 15.7164ZM17.3876 9.7282C17.3876 9.3182 17.0376 8.9782 16.5976 8.9782C16.1576 8.9782 15.8076 9.3182 15.8076 9.7282L15.8076 15.7082C15.8076 16.1282 16.1576 16.4582 16.5976 16.4582C17.0376 16.4582 17.3876 16.1282 17.3876 15.7082L17.3876 9.7282ZM15.8076 20.9528L17.3876 20.9528L17.3876 19.4528L15.8076 19.4528L15.8076 20.9528Z"
    }, title: "公告"
  });
  menus.value.push({
    id:3,
    route:"/user/message",
    icon: {
      width: "32.5400390625",
      height: "28.9100341796875",
      viewBox: "-2 0 32.5400390625 28.9100341796875",
      fill: "#646464",
      opacity: "1",
      d: "M8.9902 27.63C10.9502 28.47 13.0802 28.91 15.2702 28.91C23.7002 28.91 30.5402 22.43 30.5402 14.45C30.5402 6.47003 23.7002 3.05176e-05 15.2702 3.05176e-05C6.8402 3.05176e-05 0.0002 6.47003 0.0002 14.45C0.0002 17.37 0.9202 20.16 2.6102 22.53L0.0802 27.77C-0.1998 28.35 0.3202 29 0.9902 28.89L8.9902 27.63ZM15.2665 1.60583C7.7765 1.60583 1.6965 7.35583 1.6965 14.4558C1.6965 17.1958 2.6065 19.8058 4.2665 21.9758C4.4465 22.2058 4.4765 22.5158 4.3465 22.7758L2.2865 27.0658L8.9665 26.0058C8.9665 26.0058 9.3165 26.0058 9.4765 26.0758C11.2665 26.8758 13.2365 27.2958 15.2665 27.2958C22.7665 27.2958 28.8365 21.5458 28.8365 14.4558C28.8365 7.35583 22.7665 1.60583 15.2665 1.60583Z"
    }, title: "留言"
  });
  menus.value.push({
    id:4,
    route:"/userinfo",
    icon: {
      width: "33.92578125",
      height: "32.113494873046875",
      viewBox: "0 0 33.92578125 32.113494873046875",
      fill: "#646464",
      opacity: "1",
      d: "M19.18 4.42C17.93 2.67 15.84 1.61 13.57 1.61C9.82 1.61 6.78 4.48 6.78 8.03C6.78 10.3 8.03 12.36 10.04 13.52C10.44 13.75 10.57 14.24 10.32 14.62C10.23 14.76 10.1 14.87 9.95 14.93L3.07 18.28C2.23 18.7 1.7 19.52 1.7 20.43L1.7 21.68C1.7 23.01 2.83 24.09 4.24 24.09C4.71 24.09 5.09 24.45 5.09 24.89C5.09 25.33 4.71 25.69 4.24 25.69C1.9 25.69 0 23.9 0 21.68L0 20.43C0 18.92 0.89 17.55 2.3 16.86L7.99 14.08C6.18 12.58 5.09 10.39 5.09 8.03C5.09 3.59 8.88 0 13.57 0C16.41 0 19.02 1.34 20.58 3.52C20.85 3.89 20.75 4.39 20.36 4.64C19.97 4.88 19.44 4.79 19.18 4.42ZM11.8756 14.4534C11.8756 10.0134 15.6756 6.4234 20.3556 6.4234C25.0456 6.4234 28.8356 10.0134 28.8356 14.4534C28.8356 17.0234 27.5656 19.3134 25.5756 20.7834L31.4456 23.3034C32.9556 23.9534 33.9256 25.3834 33.9256 26.9534L33.9256 28.1034C33.9256 30.3234 32.0256 32.1134 29.6856 32.1134L11.0256 32.1134C8.6856 32.1134 6.7856 30.3234 6.7856 28.1034L6.7856 26.9534C6.7856 25.3834 7.7556 23.9534 9.2756 23.3034L15.1356 20.7834C13.1456 19.3134 11.8756 17.0234 11.8756 14.4534ZM27.1415 14.4493C27.1415 10.9093 24.1015 8.0293 20.3615 8.0293C16.6115 8.0293 13.5715 10.9093 13.5715 14.4493C13.5715 17.9993 16.6115 20.8793 20.3615 20.8793C24.1015 20.8793 27.1415 17.9993 27.1415 14.4493ZM9.9722 24.7716L16.9022 21.7916C17.9522 22.2416 19.1222 22.4816 20.3522 22.4816C21.5922 22.4816 22.7622 22.2416 23.8122 21.7916L30.7422 24.7716C31.6522 25.1616 32.2322 26.0216 32.2322 26.9616L32.2322 28.1016C32.2322 29.4316 31.0922 30.5116 29.6922 30.5116L11.0222 30.5116C9.6222 30.5116 8.4822 29.4316 8.4822 28.1016L8.4822 26.9616C8.4822 26.0216 9.0622 25.1616 9.9722 24.7716Z"
    }, title: "人员管理"
  });
  //<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="" height="" viewBox="" fill="none"><g opacity="1"  transform="translate(0 0)"><path id="Shape" fill-rule="evenodd" style="fill:" opacity="1" d=""></path></g></svg>
  menus.value.push({
    id:5,
    route:"/userinfo",
    icon: {
      width: "35.26611328125",
      height: "43.79620361328125",
      viewBox: "6 0 35.26611328125 43.79620361328125",
      fill: "#646438",
      d:"M20.12 5.37503C18.54 5.37503 17.25 6.57503 17.25 8.06503C17.25 8.55503 17.68 8.95503 18.21 8.95503C18.74 8.95503 19.17 8.55503 19.17 8.06503C19.17 7.56503 19.6 7.16503 20.12 7.16503L25.87 7.16503C26.4 7.16503 26.83 7.56503 26.83 8.06503C26.83 8.55503 27.26 8.95503 27.79 8.95503C28.32 8.95503 28.75 8.55503 28.75 8.06503C28.75 6.57503 27.46 5.37503 25.87 5.37503L20.12 5.37503ZM34.5033 11.6466L34.5033 33.1466C34.5033 34.6266 33.2132 35.8366 31.6233 35.8366L14.3733 35.8366C12.7833 35.8366 11.5033 34.6266 11.5033 33.1466L11.5033 11.6466C11.5033 10.1566 12.7833 8.95663 14.3733 8.95663C14.9033 8.95663 15.3333 8.55663 15.3333 8.06663C15.3333 7.56663 14.9033 7.16663 14.3733 7.16663C11.7233 7.16663 9.58325 9.16663 9.58325 11.6466L9.58325 33.1466C9.58325 35.6166 11.7233 37.6266 14.3733 37.6266L31.6233 37.6266C34.2733 37.6266 36.4133 35.6166 36.4133 33.1466L36.4133 11.6466C36.4133 9.16663 34.2733 7.16663 31.6233 7.16663C31.0933 7.16663 30.6633 7.56663 30.6633 8.06663C30.6633 8.55663 31.0933 8.95663 31.6233 8.95663C33.2132 8.95663 34.5033 10.1566 34.5033 11.6466Z M29.7033 17.915C30.2333 17.915 30.6633 17.515 30.6633 17.025C30.6633 16.525 30.2333 16.125 29.7033 16.125L16.2933 16.125C15.7633 16.125 15.3333 16.525 15.3333 17.025C15.3333 17.515 15.7633 17.915 16.2933 17.915L29.7033 17.915Z M16.2933 23.29L29.7033 23.29C30.2333 23.29 30.6633 22.89 30.6633 22.4C30.6633 21.9 30.2333 21.5 29.7033 21.5L16.2933 21.5C15.7633 21.5 15.3333 21.9 15.3333 22.4C15.3333 22.89 15.7633 23.29 16.2933 23.29Z M25.8733 28.665C26.4033 28.665 26.8333 28.265 26.8333 27.775C26.8333 27.275 26.4033 26.875 25.8733 26.875L16.2933 26.875C15.7633 26.875 15.3333 27.275 15.3333 27.775C15.3333 28.265 15.7633 28.665 16.2933 28.665L25.8733 28.665Z",
      opacity: "1",
    }, title: "项目管理"
  });
}

onBeforeMount(()=>{
  registerMenuList();
});
onMounted(()=>{
addLeftMenuListen();
setPage(1);
});
</script>