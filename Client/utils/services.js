import axios from 'axios'

const URL_API = process.env.NEXT_PUBLIC_URL_API

export const getProducts = () => {
  return axios
    .get(`${URL_API}/products`)
    .then((res) => console.log(res))
    .catch((e) => console.log(e.response))
}

export const createUser = (data) => {
  return axios.post(`${URL_API}/auth/register-user`, data).then((res) => res)
}
export const loginUser = (data) => {
  return axios.post(`${URL_API}/auth/login`, data)
}
