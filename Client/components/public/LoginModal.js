import { useContext, useState } from 'react'
import Image from 'next/image'
import styled from 'styled-components'
import { useForm } from 'react-hook-form'
import * as yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'

import ImageLogin from '@/public/images/BackGround_login.png'
import Logo from '@/public/images/main-logo.png'

import { Input } from '../common/Input'
import { Button } from '../common/Button'
import { RegisterContent } from './RegisterContent'

import { GlobalContext } from '@/context/GlobalContext'
import { UserContext } from '@/context/UserContext'
import { loginUser } from '@/utils/services'

const schema = yup.object().shape({
  username: yup
    .string()
    .email('Tiene que ser con formato de email')
    .required('El email es requerido'),
  password: yup.string().required('La contraseña es requerida'),
})

export const LoginModal = () => {
  const [visible, setVisible] = useState(false)
  const { setUser } = useContext(UserContext)
  const {
    register,
    formState: { errors },
    handleSubmit,
    reset,
  } = useForm({ resolver: yupResolver(schema) })
  const { contextDataGlobal, setContextDataGlobal } = useContext(GlobalContext)

  const onSubmit = (data) => {
    const response = loginUser(data)
    response
      .then((res) => {
        if (res?.status === 201) {
          setUser(res.data)
          reset()
          setContextDataGlobal({
            ...contextDataGlobal,
            modalActive: '',
            showModal: false,
          })
        }
      })
      .catch((e) => console.log('error: ', e))
  }
  return (
    <Container>
      <Image
        src={Logo}
        alt="logo"
        className="logo-icon"
        height={80}
        width={300}
      />
      <div className="image">
        <Image src={ImageLogin} alt="login-image" />
      </div>

      {visible ? (
        <div className="form">
          <RegisterContent
            setVisible={setContextDataGlobal}
            visible={contextDataGlobal}
          />
        </div>
      ) : (
        <div className="form">
          <h2>Bienvenido</h2>
          <p>Iniciar sesión con su cuenta</p>
          <form onSubmit={handleSubmit(onSubmit)}>
            <Input
              register={register('username')}
              registerInput="username"
              placeholder="Ingresar correo"
              label="Ingresar correo"
              errors={errors?.username?.message}
              margin="24px 0 31px"
            />
            <Input
              register={register('password')}
              registerInput="password"
              placeholder="Ingresar clave"
              label="Ingresar clave"
              type="password"
              errors={errors?.password?.message}
              margin="0px 0 10px"
            />
            <div className="section-links">
              <p onClick={() => setVisible(true)}>Registrarme</p>
              <p>Olvide mi clave</p>
            </div>
            <Button
              type="submit"
              text="LOGIN"
              width="200px"
              colorFocus="#25da2d"
              margin="0 0 24px"
            />
          </form>
          <div className="centered">
            <Button
              type="submit"
              text="Login con Facebook"
              width="200px"
              colorFocus="#3B5998"
              secondary="true"
            />
          </div>
        </div>
      )}
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: row;
  border-radius: 16px;
  position: relative;
  min-width: 824px;
  background: #d1d1d1;
  .image {
    background-color: var(--secondaryViolet1);
    border-radius: 16px 0px 0px 16px;
  }
  .logo-icon {
    position: absolute;
    left: 40px;
    top: 42%;
  }

  .form {
    display: flex;
    flex-direction: column;
    display: flex;
    flex-direction: column;
    padding: 82px 0;
    margin: 0 auto;
    form {
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    h2 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 400;
      font-size: 20px;
      line-height: 26px;
    }
    p {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 20px;
      line-height: 26px;
    }
    .section-links {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      margin: 0 0 25px;
      width: 100%;
      p {
        cursor: pointer;
        font-family: 'Raleway';
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        line-height: 26px;
        color: #120628;
      }
    }
  }
  .centered {
    margin: 0 auto;
  }
`
