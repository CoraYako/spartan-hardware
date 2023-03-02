import { Input } from '@/components/common/Input'
import styled from 'styled-components'
import { motion } from 'framer-motion'
import { CardShipping } from './CardShipping'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'
import { Button } from '@/components/common/Button'
import { useContext } from 'react'
import { UserContext } from '@/context/UserContext'
import { useForm } from 'react-hook-form'

const schema = yup.object().shape({
  state: yup.string().required('La provincia es requerida'),
  code: yup.string().max(32).required('El codigo postal es obligatorio'),
})

export const FirstStep = ({ onClick }) => {
  const { setUser, user } = useContext(UserContext)
  const {
    register,
    formState: { errors },
    handleSubmit,
  } = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      state: user?.state || '',
      code: user?.code || '',
    },
  })

  const onSubmit = (data) => {
    setUser({ ...user, state: data.state, code: data.code })
    onClick()
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Container
        variants={{ collapsed: { scale: 0.8 }, open: { scale: 1 } }}
        transition={{ duration: 0.4 }}
        key="content"
        initial="collapsed"
        animate="open"
        exit="collapsed"
      >
        <div className="inputs">
          <Input
            register={register('state')}
            registerInput={'state'}
            errors={errors?.state?.message}
            label="Ingresa tu provincia"
            placeholder="Provincia"
          />
          <Input
            register={register('code')}
            registerInput={'code'}
            errors={errors?.code?.message}
            label="Numero postal"
            placeholder="Numero postal"
          />
        </div>
        <h6>Retira tu producto en las siguientes sucursales</h6>
        <div className="cards">
          <CardShipping
            titleName="Sucursal 1"
            price="Gratis"
            info="Remedios de escalada de San Martin 3875"
          />
          <CardShipping
            titleName="Sucursal 2"
            price="Gratis"
            info="Remedios de escalada de San Martin 3875"
          />
        </div>
        <h6>Recibe tu producto a domicilio</h6>
        <div className="cards">
          <CardShipping
            titleName="Domicilio 1"
            price="$ 2389.46"
            info="Llega en 3 dias desde su despacho"
          />
          <CardShipping
            titleName="Domicilio 2"
            price="$ 2389.46"
            info="Llega en 3 dias desde su despacho"
          />
        </div>
        <Button text="Siguiente paso" type="submit" />
      </Container>
    </form>
  )
}

const Container = styled(motion.div)`
  display: flex;
  flex-direction: column;
  padding: 40px 30px;
  background-color: #fff;
  border-radius: 0 0 8px 8px;
  input {
    border-radius: 4px;
    border: 1px grey solid;
    :focus {
      border-radius: 4px;
      border: 1px grey solid;
    }
  }

  .inputs {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  h6 {
    font-style: normal;
    font-weight: 700;
    font-size: 20px;
    line-height: 26px;
    margin-top: 30px;
  }
  .cards {
    display: flex;
    flex-direction: row;
    gap: 60px;
    margin: 20px 0 0;
  }
`
