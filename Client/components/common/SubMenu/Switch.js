import { useContext, useState } from 'react'
import { motion } from 'framer-motion'
import styled from 'styled-components'
import { GlobalContext } from '@/context/GlobalContext'

export const Switch = () => {
  const { setContextDataGlobal, contextDataGlobal } = useContext(GlobalContext)
  const [toggleDirection, setToggleDirection] = useState(20)
  const toggleOn = () => {
    if (toggleDirection) {
      setContextDataGlobal({ ...contextDataGlobal, theme: 'light' })
    } else {
      setContextDataGlobal({ ...contextDataGlobal, theme: 'dark' })
    }
    setToggleDirection(toggleDirection === 0 ? 20 : 0)
  }

  return (
    <Container onClick={toggleOn}>
      <p>{!toggleDirection ? 'MODO CLARO' : 'MODO OSCURO'}</p>
      <ToggleBackground
        style={{
          background: toggleDirection ? '#095c00' : '#d6d6d6',
        }}
      >
        <ToggleCircle
          onTap={toggleOn}
          animate={{
            x: toggleDirection,
          }}
          transition={{
            type: 'spring',
            stiffness: 700,
            damping: 30,
          }}
          style={{
            background: '#25DA2D',
          }}
        />
      </ToggleBackground>
    </Container>
  )
}

const ToggleBackground = styled(motion.div)`
  width: 40px;
  height: 20px;
  background-color: rgba(255, 255, 255, 0.4);
  display: flex;
  justify-content: flex-start;
  border-radius: 50px;
  padding: 2px 1.5px;
  cursor: pointer;
`

const ToggleCircle = styled(motion.div)`
  width: 15px;
  height: 15px;
  background-color: white;
  border-radius: 40px;
`
const Container = styled.div`
  min-width: 170px;
  cursor: pointer;
  display: flex;
  user-select: none;
  gap: 10px;
  justify-content: space-between;

  p {
    font-weight: 700;
  }
`
