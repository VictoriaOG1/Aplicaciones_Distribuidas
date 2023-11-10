let shareSymbol;
let numShares;
let sharePrice;
let accumValue = 0.0;
let portfolio = {};
let sharePriceDictionary = {};
process.stdin.setEncoding("utf8");
process.stdin.resume();

const getShareName = () => {
  console.log("Enter the stock symbol or type 'q' to quit");
  process.stdin.once("data", (data) => {
    const input = data.toString().trim();
    if (input === "q") {
      end.next();
      end.next();
    } else {
      shareSymbol = input;
      seq.next();
    }
  });
};

const getNumShares = () => {
  console.log("Enter the number of shares");
  process.stdin.once("data", (data) => {
    numShares = parseFloat(data.toString().trim());
    seq.next();
  });
};

const getPriceOfShare = () => {
  console.log("Enter the price of the share");
  process.stdin.once("data", (data) => {
    sharePrice = parseFloat(data.toString().trim());
    seq.next();
    seq.next();
  });
};

const addPortfolio = () => {
  if (shareSymbol in portfolio) {
    portfolio[shareSymbol] += numShares;
  } else {
    portfolio[shareSymbol] = numShares;
  }
  sharePriceDictionary[shareSymbol] = sharePrice;
  console.log("Portfolio: ", portfolio);
  console.log("Share Price Dictionary: ", sharePriceDictionary);
};

const getPortfolioValue = () => {
  let accumValue = 0.0;
  for (const stock in portfolio) {
    const shares = portfolio[stock];
    const price = sharePriceDictionary[stock];
    accumValue += shares * price;
  }
  return accumValue;
};

const exit = () => {
  const portfolioValue = getPortfolioValue();
  console.log(`The value of your portfolio is ${portfolioValue.toFixed(2)}`);
  process.exit(0);
};

const tasks = [
  getShareName,
  getNumShares,
  getPriceOfShare,
  addPortfolio,
  getPortfolioValue,
  exit,
];

function* IteratorTasks() {
  let index = 0;
  while (true) {
    yield tasks[index]();
    index = (index + 1) % (tasks.length - 2); // Reiniciar al inicio cuando llegamos al final
  }
}

function* EndTasks() {
  for (let i = tasks.length - 2; i < tasks.length; i++) {
    yield tasks[i]();
  }
}

let seq = IteratorTasks();
let end = EndTasks();
seq.next();
