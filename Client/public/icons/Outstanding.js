import * as React from 'react'

const OutstandingIcon = (props) => (
  <svg
    width={15}
    height={15}
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
    {...props}
  >
    <path
      d="M4.25 14.5a3 3 0 0 1 3-3v-.75a3.75 3.75 0 0 1-3.675-3H2.75A2.25 2.25 0 0 1 .5 5.5V1.75H2c.578 0 1.103.218 1.5.57V.25h8.25v2.07c.398-.352.922-.57 1.5-.57h1.5V5.5a2.25 2.25 0 0 1-2.25 2.25h-.825a3.75 3.75 0 0 1-3.675 3v.75a3 3 0 0 1 3 3H4.25ZM8 12.25h-.75c-.982 0-1.815.623-2.122 1.5h4.995A2.242 2.242 0 0 0 8 12.25ZM11 1H4.25v6a3 3 0 0 0 3 3H8a3 3 0 0 0 3-3V1Zm3 4.5v-3h-.75a1.5 1.5 0 0 0-1.5 1.5v3h.75A1.5 1.5 0 0 0 14 5.5Zm-12.75 0A1.5 1.5 0 0 0 2.75 7h.75V4A1.5 1.5 0 0 0 2 2.5h-.75v3Z"
      fill="#000"
    />
  </svg>
)

export default OutstandingIcon
