import axios from "axios"

const request = axios.create({
    baseURL : "https://i8a102.p.ssafy.io/api"
})

export const api = {
    cartdata : {
        findUserbySeq:(seq) => request.get(`/user/all/${seq}`),
        findUserbyId:(userid) => request.get(`user/${userid}`),
        getItem:(item) => request.get(`/product`,{params:{"key":"name","word":item}}),
        getItembyId:(itemid) => request.get(`/product/searchbyseq/${itemid}`),
        getItembyName:(itemname) => request.get(`/product/searchbyname/${itemname}`),
        getCompbyId:(compid) => request.get(`/company/${compid}`),
        getList:(id) => request.get(`/cartlist/${id}`), //장바구니 목록 조회
        // getdetailList:(id) => request.get(``),
        purchaseList:(list) => request.post(`/purchase`,list),
        getImgbyId:(itemid) => request.get(`/image/product/${itemid}`),
        getRecipebyItem:(itemid) => request.get(`recipe/product/${itemid}`),
        getRecipebySeq:(rseq) => request.get(`/recipe/${rseq}`),
        getRecipeImg:(rseq) => request.get(`/image/recipe/${rseq}`),
        getTheme:() => request.get(`/theme`),
        getThemebySeq:(tseq) => request.get(`/theme/seq/${tseq}`)
    }
}