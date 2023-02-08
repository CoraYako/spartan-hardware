import styled from 'styled-components'

export const Details = ({ details }) => {
  return (
    <Container>
      <p>Interruptor: Mecanico</p>
      <p>Retroiluminado: Si</p>
      <p>Tipo de conexión: USB</p>
      <p>Peso: 474</p>
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 5px;
  margin-top: 1rem;
`
