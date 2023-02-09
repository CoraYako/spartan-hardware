import styled from 'styled-components'

export const Details = ({ details, alignItems = '', byPromotion = false }) => {
  return (
    <Container alignItems={alignItems}>
      <p>{details?.first || 'Interruptor: Mecanico'}</p>
      <p>{details?.second || 'Retroiluminado: Si'}</p>
      <p>{details?.three || 'Tipo de conexión: USB'}</p>
      {!byPromotion && <p>{details?.four || 'Peso: 474'}</p>}
    </Container>
  )
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 5px;
  margin-top: 1rem;
  align-items: ${(props) => props.alignItems};
`
