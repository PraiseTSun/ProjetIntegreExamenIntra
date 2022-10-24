import React from 'react';
import { render, screen } from '@testing-library/react';
import Addition from "./components/Addition";
import Soustraction from "./components/Soustraction";

// global.fetch = jest.fn(() => Promise.resolve({
//   json: () => Promise.resolve(
//       {
//         answer: 10
//       }
//   )
// }))

describe("Addition",() =>{
  it("get the answer of addition", () => {
    const {container} = render(<Addition/>)
    expect(container.innerHTML).toMatch("10")
  })
})

describe("Soustraction",() =>{
    it("get the answer of Soustraction", () => {
        const {container} = render(<Addition/>)
        expect(container.innerHTML).toMatch("10")
    })
})
