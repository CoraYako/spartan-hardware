import styled from 'styled-components'
import { motion } from 'framer-motion'
import { ProductCard } from '../../common/ProductCard'
import { Anchor } from '../../common/Anchor'
import axios from 'axios'
import { useQuery } from 'react-query'

export const Outstanding = ({ props }) => {
  const URL_API = process.env.NEXT_PUBLIC_URL_API
  const { isLoading, error, data } = useQuery(['recommended'], () =>
    axios
      .get(`${URL_API}/api/v1/products/recommended`)
      .then((res) => res.data)
      .catch((e) => console.log(e.response)),
  )

  const shuffled = data?.sort(() => 0.5 - Math.random())
  const selected = shuffled?.slice(0, 4)
  return (
    <Main>
      <div className="title">
        <h2>Productos Destacados</h2>
        <Anchor text="Ver más" to="#" />
      </div>
      <div className="outstanding">
        {data &&
          selected.map((item) => (
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
            />
          ))}
      </div>
    </Main>
  )
}

const Main = styled(motion.section)`
  max-width: 1300px;
  display: flex;
  flex-direction: column;
  margin: 70px auto 0;
  padding: 0 2.5rem;
  .title {
    display: flex;
    gap: 13px;
  }

  .outstanding {
    display: flex;
    flex-direction: row;
    gap: 16px;
    padding: 3.5rem 0;
    flex-wrap: wrap;
  }
`
