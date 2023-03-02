import { motion } from 'framer-motion'
import styled from 'styled-components'
import MercadoPago from '@/public/images/mercado-pago.svg'
import PaymentTranf from '@/public/images/trans.svg'
import Cards from '@/public/images/vector.svg'
import Visa from '@/public/images/Visa.svg'
import mastercard from '@/public/images/mastercard.svg'
import { Payments } from './Payments'

export const StepTwo = () => {
  return (
    <Container
      variants={{ collapsed: { scale: 0.8 }, open: { scale: 1 } }}
      transition={{ duration: 0.5 }}
      key="content"
      initial="collapsed"
      animate="open"
      exit="collapsed"
    >
      <Payments image={MercadoPago} title="Mercado Pago" />
      <Payments image={PaymentTranf} title="Transferencia" />
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
