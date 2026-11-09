// Change a depth or the pressure rule, then compare the holding assignments.
const specimens = [
  { species: "VampireSquid", depth: 900 },
  { species: "Anglerfish", depth: 2100 },
  { species: "GulperEel", depth: 1500 }
];

/**
 * Estimates pressure using the simulation's species adjustment.
 * Precondition: specimen has a species name and a nonnegative depth in meters.
 * Postcondition: Returns the estimated atmospheres without changing the specimen.
 * @param {{species: string, depth: number}} specimen the observed species and its depth in meters
 * @returns {number} Estimated pressure in atmospheres.
 */
function pressureFor(specimen) {
  const baseline = 1 + specimen.depth / 10;
  return specimen.species === "VampireSquid" ? baseline * 1.08 : baseline;
}

const report = [];
for (const specimen of specimens) {
  const pressure = pressureFor(specimen);
  const highCompression = specimen.depth >= 1000 && pressure >= 100;
  report.push(specimen.species + " | " + pressure.toFixed(1) + " atm | " +
    (highCompression ? "HIGH COMPRESSION" : "LOW COMPRESSION"));
}
document.querySelector("pre").textContent = report.join("\n");
console.log(report.join("\n"));
