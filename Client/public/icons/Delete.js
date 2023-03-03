import * as React from 'react'

const DeleteIcon = (props) => (
  <svg
    width={15}
    height={19}
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
    {...props}
  >
    <path
      d="M14 16a3 3 0 0 1-3 3H4a3 3 0 0 1-3-3V4H0V1h4.5l1-1h4l1 1H15v3h-1v12ZM2 4v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2-2V4H2Zm12-1V2h-4L9 1H6L5 2H1v1h13ZM4 6h1v10H4V6Zm6 0h1v10h-1V6Z"
      fill="#fff"
      fillOpacity={0.8}
    />
  </svg>
)

export default DeleteIcon
