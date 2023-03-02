import { useState } from 'react'
import styled from 'styled-components'
import { Accordion } from './Accordion'
import { FirstStep } from './FirstStep'

export const Steps = () => {
  const [expanded, setExpanded] = useState(1)
  const [stepsCompleted, setStepsCompleted] = useState({
    step1: false,
    step2: false,
  })
  return (
    <Container>
      <Accordion
        i={1}
        setExpanded={setExpanded}
        expanded={expanded}
        title="1. Elegi la opción de retiro o envio de tu compra"
        disabled={true}
      >
        <FirstStep
          onClick={() => {
            setStepsCompleted({ ...stepsCompleted, step1: true })
            setExpanded(2)
          }}
        />
      </Accordion>
      <Accordion
        i={2}
        setExpanded={setExpanded}
        expanded={expanded}
        title="2. SELECCIONA EL METODO DE PAGO Y FINANCIACIÓN"
        disabled={stepsCompleted?.step1}
      >
        Test
      </Accordion>
      <Accordion
        i={3}
        setExpanded={setExpanded}
        expanded={expanded}
        title="3. Finaliza tu compra"
        disabled={stepsCompleted?.step2}
      >
        Test
      </Accordion>
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
`
