import {request} from '@/main'
import {Ref} from "vue";
import router from "@/router";
import {ElNotification} from "element-plus";
function UserLogin(username:string,password:string,message:Ref<string>):void{
    request.post('/usersignin/login', {
        "username": username,
        "password": password
    }).then(r =>{
        console.log(r.data.msg);
        message.value=r.data.msg;
        if(r.data.code===200){
            ElNotification({title:"成功",message:message.value,type:"success",customClass:"LoginSuccess",duration:800});
            router.replace("/user");
        }else {
            ElNotification({title:"失败",message:message.value,type:"error",customClass:"LoginError",duration:800});
        }
    });
}

export default UserLogin;