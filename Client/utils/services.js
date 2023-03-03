import axios from 'axios'

const URL_API = process.env.NEXT_PUBLIC_URL_API

export const createUser = (data) => {
  return axios
    .post(`${URL_API}/api/v1/auth/register-user`, data)
    .then((res) => res)
}
export const loginUser = (data) => {
  return axios.post(`${URL_API}/api/v1/auth/login`, data)
}
