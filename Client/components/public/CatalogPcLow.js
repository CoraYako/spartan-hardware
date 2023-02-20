import styled from 'styled-components'
import CheckboxSpring from '../common/Checkbox'

export const CatalogPcLow = () => {
  return (
    <Container>
      <div className="categories">
        <h3>Ordenar productos</h3>
        <p>Menor precio</p>
        <p>Marca</p>
        <div className="filter">
          <CheckboxSpring text="AMD" quantity="10" />
          <CheckboxSpring text="Intel" quantity="7" />
        </div>
        <p>Entrega inmediata</p>
        <p>Linea de procesador</p>
      </div>
      <div></div>
    </Container>
  )
}

const Container = styled.div`
  width: 1300px;
  margin: 137px auto 0;
  .filter {
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin: 0 0 0 15px;
  }
  .categories {
    h3 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 20px;
      line-height: 26px;
    }
    p {
      font-style: normal;
      font-weight: 600;
      font-size: 16px;
      line-height: 26px;
    }
  }
`
