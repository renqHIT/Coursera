## The function makecacheMatrix accept a matrix x and returns a list containing 
## four functions: set, get, setsolve and getsolve.

makeCacheMatrix <- function(x = matrix()) 
{
    my.x <- x				# my.x is a copy of the parameter x inside mamecacheMatrix function,
    my.solve <- NULL	        # inverse matrix of x
    is.cached <- FALSE		# logistic viriable, denoting whether x has an inverse matrix stored in my.solve
    
    set <- function(y) 
    {
        x <<- y
        is.cached <<- FALSE
    }
    
    get <- function() x
    
    setsolve <- function(solve)
    {
        my.solve <<- solve
        is.cached <<- TRUE
    }
    
    getsolve <- function() my.solve
    
    list(set = set, get = get,
         setsolve = setsolve,
         getsolve = getsolve)
}

## The function cacheSolve accept a matrix x and returns the inverse matrix of x.
## If the inverse matrix of x in cached, it can return this cache. 
## Otherwise, compute the inverse matrix and cache this inverse matrix using x$setsolve(s)
## In this way, 
cacheSolve <- function(x, ...) 
{
    ## First check whether x has changed from the cached x.
    #data <- x$get()
    #if(is.cached)
    #{
        ## Inverse is in cache
        if(length(x$getsolve()) != 0) 
        {
            print("getting cached data")
            return(x$getsolve())
        }
    #}
    ## inverse not in cache or x has changed, recompute inverse 
    s <- solve(x)
    x$setsolve(s)
    s
}

## Test case
x <- c(2, 3, 4, 5)
x <- matrix(x, 2, 2)

#hilbert <- function(n) { i <- 1:n; 1 / outer(i - 1, i, "+") }
#x <- hilbert(1000)
l <- makecacheMatrix(x)
m <- cacheSolve(l)		# have cache
print(m)
n <- cacheSolve(l)		# not have cache
x <- c(3, 4, 5, 6)
x <- matrix(x, 2, 2)
l <- makecacheMatrix(x)	# change x value
m <- cacheSolve(l)		# recompute reverse
print(m)
n <- cacheSolve(l)		# read cache
print(n)