import { Input } from '@/components/common/Input'
import styled from 'styled-components'
import { useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'
import { useContext } from 'react'
import { UserContext } from '@/context/UserContext'
import CheckboxSpring from '@/components/common/Checkbox'
import { Button } from '@/components/common/Button'

const schema = yup.object().shape({
  phone: yup.string().required('El numero celular es requerido'),
  typeClass: yup.string().max(32).required('La clase fiscal es obligatoria'),
  ID: yup.string().max(32).required('El DNI es obligatorio'),
  street: yup.string().max(32).required('La calle es obligatoria'),
  streetNumber: yup
    .string()
    .max(32)
    .required('El numero de la calle es obligatorio'),
  location: yup.string().max(32).required('La localidad es obligatoria'),
})

export const StepThree = () => {
  const { setUser, user } = useContext(UserContext)
  const {
    register,
    formState: { errors },
    handleSubmit,
  } = useForm({
    resolver: yupResolver(schema),
  })

  const onSubmit = (data) => {
    setUser({ ...user, ...data })
  }
  return (
    <Container
      variants={{ collapsed: { scale: 0.8 }, open: { scale: 1 } }}
      transition={{ duration: 0.5 }}
      key="content"
      initial="collapsed"
      animate="open"
      exit="collapsed"
    >
      <h2>Datos del titular del medio de pago</h2>
      <div className="personal_info">
        <h4>
          Nombre: {user.firstName} {user.lastName}
        </h4>
        <h4>Email: {user.email}</h4>
      </div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="two_inputs">
          <Input
            label="Numero de Telefono"
            placeholder="Numero de Telefono"
            register={register('phone')}
            errors={errors?.phone?.message}
          />
          <Input
            label="Clase Fiscal"
            placeholder="(Monotributista, Consumidor final, etc)"
            register={register('typeClass')}
            errors={errors?.typeClass?.message}
          />
        </div>
        <div className="directions">
          <Input
            label="Numero de Documento"
            placeholder="Numero de Documento"
            register={register('ID')}
            errors={errors?.ID?.message}
          />
          <Input
            label="Calle"
            placeholder="Calle"
            register={register('street')}
            errors={errors?.street?.message}
          />
          <Input
            label="Numero"
            placeholder="Numero de calle"
            register={register('streetNumber')}
            errors={errors?.streetNumber?.message}
          />
          <Input
            label="Piso"
            placeholder="Opcional"
            register={register('floor')}
            errors={errors?.floor?.message}
          />
          <Input
            label="Depto"
            placeholder="Opcional"
            register={register('numberFloor')}
            errors={errors?.numberFloor?.message}
          />
          <Input
            label="Localidad"
            placeholder="Localidad"
            register={register('location')}
            errors={errors?.location?.message}
          />
        </div>
        <CheckboxSpring text="Al tildar acepta los Terminos y Condiciones de Compra" />
        <Button text="FINALIZAR COMPRA" type="submit" margin="20px 0" />
      </form>
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 15px 0;
  padding: 15px 30px;
  background-color: #fff;
  border-radius: 0 0 8px 8px;

  form {
    display: flex;
    flex-direction: column;
  }
  .directions {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 30px;
    justify-content: space-around;
    margin: 40px 0;
  }
  .two_inputs {
    display: flex;
    flex-direction: row;
    gap: 30px;
    justify-content: space-around;
    margin: 10px 0 0;
  }
  input {
    border-radius: 4px;
    border: 1px grey solid;
    :focus {
      border-radius: 4px;
      border: 1px grey solid;
    }
  }
  h2 {
    font-style: normal;
    font-weight: 700;
    font-size: 20px;
    line-height: 26px;
    color: #454545;
  }
  .personal_info {
    display: flex;
    flex-direction: column;
    gap: 10px;
    h4 {
      font-style: normal;
      font-weight: 600;
      font-size: 16px;
      line-height: 26px;
    }
  }
`
