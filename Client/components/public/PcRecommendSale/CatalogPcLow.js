import { ProductCard } from '@/components/common/ProductCard'
import styled from 'styled-components'
import CheckboxSpring from '../../common/Checkbox'
import { Items } from './mock'

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
        <div className="filter">
          <CheckboxSpring text="Entrega inmediata" quantity="3" />
        </div>
        <p>Linea de procesador</p>
        <div className="filter">
          <CheckboxSpring text="Amd Kit Ryzen 7" quantity="10" />
          <CheckboxSpring text="Intel Celeron" quantity="5" />
          <CheckboxSpring text="Intel I5 Cuarta G" quantity="15" />
        </div>
      </div>
      <div className="products">
        {Items &&
          Items.map((item) => (
            <ProductCard
              key={item.id}
              img={item.img}
              title={item.title}
              details={item.details}
              price={item.price}
              promotion={item.promotion}
              fastSend={item.fastSend}
              product={item}
            />
          ))}
      </div>
    </Container>
  )
}

const Container = styled.div`
  max-width: 1300px;
  margin: 0 auto 0;
  padding: 60px 22px;
  display: flex;
  flex-direction: row;
  gap: 20px;
  .products {
    max-width: 950px;
    display: flex;
    flex-direction: row;
    gap: 50px 30px;
    flex-wrap: wrap;
    justify-content: center;
  }
  .filter {
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin: 15px 0 15px 15px;
  }
  .categories {
    min-width: 292px;
    h3 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 20px;
      line-height: 26px;
      margin-bottom: 15px;
    }
    p {
      font-style: normal;
      font-weight: 600;
      font-size: 16px;
      line-height: 26px;
    }
  }
`
