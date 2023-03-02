import { Input } from '@/components/common/Input'
import styled from 'styled-components'
import { motion } from 'framer-motion'
import { CardShipping } from './CardShipping'

export const FirstStep = () => {
  return (
    <Container
      variants={{ collapsed: { scale: 0.9 }, open: { scale: 1 } }}
      transition={{ duration: 0.8 }}
      key="content"
      initial="collapsed"
      animate="open"
      exit="collapsed"
    >
      <div className="inputs">
        <Input label="Ingresa tu provincia" placeholder="Provincia" />
        <Input label="Numero postal" placeholder="Numero postal" />
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
    </Container>
  )
}

const Container = styled(motion.div)`
  display: flex;
  flex-direction: column;
  padding: 40px 30px;
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
