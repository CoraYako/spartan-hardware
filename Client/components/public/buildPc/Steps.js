import { ProductCard } from '@/components/common/ProductCard'
import { CartContext } from '@/context/CartContext'
import FormatPrice from '@/utils/FormatPrice'
import { useContext, useState } from 'react'
import styled from 'styled-components'
import { CardCategory } from './CardCategory'
import { FullSteps } from './helper'

export const Steps = ({ dataProducts, setcategory }) => {
  const { cart } = useContext(CartContext)
  const totalPrice = Math.round(
    cart.reduce((total, product) => total + product.price, 0),
  )
  const [step, setStep] = useState(1)
  const changeIndex = (n) => {
    setStep(n)
  }
  const price = '10,00'
  return (
    <>
      <Categories>
        <div className="steps">
          <h4>Paso {step} de 12</h4>
        </div>
        <h2>Total: ${totalPrice || '0'}</h2>
        <div className="list_categories">
          {FullSteps &&
            FullSteps.map((item) => (
              <CardCategory
                selected={item.index === step}
                category={item.name}
                key={item.index}
                step={item.index}
                isColumn
                icon={item.Icon}
                action={changeIndex}
                setcategory={setcategory}
                slug={item.slug}
              />
            ))}
        </div>
      </Categories>
      <ListItems>
        {dataProducts &&
          dataProducts.content?.map((item) => (
            <ProductCard
              key={item.id}
              id={item.id}
              img={'http://' + item.urlImages[0].slice(8)}
              title={item.name}
              details={item.shortDescription}
              price={item.price}
              promotion={item.recommended}
              fastSend={item.fastSend}
              product={item}
              bypcbuild
              setStep={setStep}
              step={step}
            />
          ))}
      </ListItems>
    </>
  )
}

const Categories = styled.div`
  width: 295px;
  display: flex;
  flex-direction: column;
  align-items: center;

  .list_categories {
    gap: 8px;
    display: flex;
    flex-direction: column;
    overflow-y: scroll;
    max-height: 600px;
  }

  h2 {
    margin: 25px 0;
    font-style: normal;
    font-weight: 600;
    font-size: 34px;
    line-height: 26px;
  }

  .steps {
    color: #fff;
    background-color: #120628;
    width: 100%;
    padding: 10px 0;
    text-align: center;
    h4 {
      font-family: 'Raleway';
      font-style: normal;
      font-weight: 700;
      font-size: 16px;
      line-height: 26px;
    }
  }
`

const ListItems = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-content: flex-start;
  gap: 40px 15px;
`
