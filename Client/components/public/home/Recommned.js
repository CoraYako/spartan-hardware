import styled from "styled-components";
import RecommendCard from '../../common/Cardrecord'
  
export const Recommend = () => {   
  return(
    <>
      <div className="title">
	<h2>PC's Recomendadas</h2>
      </div>
      <CardContainer>
	<RecommendCard title={"PC's BÁSICA"}/>
	<RecommendCard title={"PC's ALTA"}/>
	<RecommendCard title={"PC's ALTA"}/>
      </CardContainer>
    </>
  )
}

const CardContainer = styled.div`
  margin-top: 200px;
  height: auto;
  display: flex;
  gap: 100px;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  overflow: hidden;
`;
