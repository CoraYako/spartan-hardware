import { motion } from 'framer-motion'
import styled from 'styled-components'
import MercadoPago from '@/public/images/mercado-pago.svg'
import PaymentTranf from '@/public/images/trans.svg'
import Visa from '@/public/images/Visa.svg'
import mastercard from '@/public/images/mastercard.svg'
import { Payments } from './Payments'
import { useContext } from 'react'
import { UserContext } from '@/context/UserContext'

export const StepTwo = ({ setStepsCompleted, stepsCompleted, setExpanded }) => {
  const { user, setUser } = useContext(UserContext)
  const setTypePayment = (type, id) => {
    setUser({ ...user, payment: { type: type, id: id } })
    setStepsCompleted({ ...stepsCompleted, step2: true })
    setExpanded(3)
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
      <Payments
        image={MercadoPago}
        title="Mercado Pago"
        action={() => setTypePayment('MP', 1)}
        id={1}
      />
      <Payments
        image={PaymentTranf}
        title="Transferencia"
        action={() => setTypePayment('Transf', 2)}
        id={2}
      />
      <Payments image={Visa} title="visa" disabled />
      <Payments image={mastercard} title="Mastercard" disabled />
    </Container>
  )
}

const Container = styled(motion.div)`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 20px 50px;
  padding: 40px 30px;
  background-color: #fff;
  border-radius: 0 0 8px 8px;
`
