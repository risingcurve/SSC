// import store from "@/store";
import axios from "axios";
import VueCookies from 'vue-cookies';


//request
axios.interceptors.request.use(async function (config){
    if (config.retry==undefined){
        config.url = `${config.url}` != 'http://localhost:3333' ? `${config.url}`:'https://i8a102.p.ssafy.io/api'
    }
    config.timeout = 10000;
    // 헤더
    config.headers['access-token'] = VueCookies.get('accessToken');
    config.headers['refresh-token'] = VueCookies.get('refreshToken');
    config.headers['Content-Type'] = 'application/json';
    
    return config;
}), function (error) {
    console.log('axios request error:',error);
    return Promise.reject(error);
}

// response
axios.interceptors.response.use(
    function(response){
        try{
            return response;
        } catch(err){
            console.log('[axios,interceptors.response]response:', err.message);
        }
    },
    async function (error) {
        try{
            const errorAPI = error.response.config;
            
            if(error.response.status == 401 && errorAPI.retry == undefined && VueCookies.get('refreshToken')!= null){
                errorAPI.retry = true;
                await this.$store.dispatch('refreshToken');
                return await axios(errorAPI);
            }
        } catch(err){
            console.error('[axios.interceptors.response]error:', err.message);
        }
        return Promise.reject(error);
    }
)

export default axios