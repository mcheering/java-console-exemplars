// Change a population or a safety limit, then compare the audit results.
const habitats = [
  { name: "Dome-Alpha", population: 150 },
  { name: "Outpost-Beta", population: 45 },
  { name: "Hydro-Gamma", population: 310 }
];
const minimumOxygen = 50;
const maximumOxygen = 250;

/**
 * Estimates daily oxygen use, including the reserve for small research labs.
 * Precondition: population is a nonnegative whole number.
 * Postcondition: Returns the required oxygen units without changing the data.
 */
function oxygenNeed(population) {
  const labReserve = population <= 100 ? 3 * 15 : 0;
  return population * 1.2 + labReserve;
}

const report = [];
for (const habitat of habitats) {
  const oxygen = oxygenNeed(habitat.population);
  const stable = oxygen >= minimumOxygen && oxygen <= maximumOxygen;
  report.push(habitat.name + " | " + oxygen.toFixed(1) + " oxygen units | " +
    (stable ? "STABLE" : "CRITICAL ALERT"));
}
document.querySelector("pre").textContent = report.join("\n");
console.log(report.join("\n"));
