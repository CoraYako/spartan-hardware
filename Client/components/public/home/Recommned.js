import styled from 'styled-components'
import RecommendCard from '../../common/Cardrecord'

export const Recommend = () => {
  return (
    <>
      <div className="title">
        <h2>PC's Recomendadas</h2>
      </div>
      <CardContainer>
        <RecommendCard title={"PC's BÁSICA"} link="/pc-recommend-sale" />
        <RecommendCard title={"PC's MEDIA"} link="/pc-recommend-sale" />
        <RecommendCard title={"PC's ALTA"} link="/pc-recommend-sale" />
      </CardContainer>
    </>
  )
}

const CardContainer = styled.div`
  margin-top: 20em;
  height: auto;
  display: grid;
  gap: 5rem;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  overflow: hidden;
`
